package com.yc.music.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.yc.music.bean.MusicInfo;

public class Participle {
	private static String  tompath;


	public static  void addTo(List<Map<String, Object>> musicInfos,HttpServletRequest request){
		// 1. 采集数据
		try {
			// 2. 创建文档对象
			List<Document> documents = new ArrayList<Document>();
			for (Map<String, Object> music:musicInfos) {
				Document document = new Document();
				// 给文档对象添加域
				// add方法: 把域添加到文档对象中, field参数: 要添加的域
				// TextField: 文本域, 属性name:域的名称, value:域的值, store:指定是否将域值保存到文档中
				document.add(new TextField("mid",String.valueOf(music.get("mid")) , Store.YES));
				document.add(new TextField("mname",String.valueOf(music.get("mname")) , Store.YES));
				document.add(new TextField("pices",String.valueOf(music.get("pices")) , Store.YES));
				document.add(new TextField("musicaddr",String.valueOf(music.get("musicaddr")) , Store.YES));
				document.add(new TextField("lyricaddr",String.valueOf(music.get("lyricaddr")) , Store.YES));
				document.add(new TextField("rgdate",String.valueOf(music.get("rgdate")) , Store.YES));
				document.add(new TextField("atname",String.valueOf(music.get("atname")) , Store.YES));
				document.add(new TextField("cid",String.valueOf(music.get("cid")) , Store.YES));
				document.add(new TextField("stype",String.valueOf(music.get("stype")) , Store.YES));
				document.add(new TextField("by2",String.valueOf(music.get("by2")) , Store.YES));
				document.add(new TextField("sgname",String.valueOf(music.get("sgname")) , Store.YES));

				System.out.println( document );
				// 将文档对象添加到文档对象集合中
				documents.add(document);
			}
			System.out.println( documents );
			// 3. 创建分析器对象(Analyzer), 用于分词
			Analyzer analyzer = new StandardAnalyzer();
			// 4. 创建索引配置对象(IndexWriterConfig), 用于配置Lucene
			// 参数一:当前使用的Lucene版本, 参数二:分析器
			IndexWriterConfig indexConfig = new IndexWriterConfig( Version.LUCENE_4_10_2, analyzer);
			
			tompath = request.getServletContext().getRealPath(""); //这个是获取服务器路径  D:\tomcat\apache-tomcat-8.5.41\webapps\music\
			tompath=tompath.substring(0,(tompath.length()-6));
			tompath=tompath.replace("\\", "\\")+"index";


			// 5. 创建索引库目录位置对象(Directory), 指定索引库的存储位置
			File path = new File(tompath);
			if (!path.exists()) {
				path.mkdirs();
			}
			System.out.println( tompath );
			Directory directory = FSDirectory.open(path);
			// 6. 创建索引写入对象(IndexWriter), 将文档对象写入索引
			IndexWriter indexWriter = new IndexWriter(directory, indexConfig);
			// 7. 使用IndexWriter对象创建索引
			for (Document doc : documents) {
				// addDocement(doc): 将文档对象写入索引库
				indexWriter.addDocument(doc);
			}
			// 8. 释放资源
			indexWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}


	public static List<Map<String, Object>> searchIndexMusciInfo(String mname) throws ParseException, IOException, InvalidTokenOffsetsException{

		// 1. 创建分析器对象(Analyzer), 用于分词
		Analyzer analyzer = new StandardAnalyzer();

		


		String [] queries ={mname,mname};
		String[] fields={"sgname","mname"};

		// 2. 创建查询对象(Query)
		// 2.1 创建查询解析器对象
		// 参数一:默认的搜索域, 参数二:使用的分析器
	//	QueryParser queryParser = new QueryParser("mname", analyzer);

	//	String selemname="mname:"+mname;

		// 2.2 使用查询解析器对象, 实例化Query对象
	//	Query query = queryParser.parse(selemname);
		BooleanClause.Occur[] clauses = { BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD };  
		  Query query = MultiFieldQueryParser.parse(queries, fields, clauses, new StandardAnalyzer());  
		  

		// 3. 创建索引库目录位置对象(Directory), 指定索引库位置
		Directory directory = FSDirectory.open(new File(tompath));

		// 4. 创建索引读取对象(IndexReader), 用于读取索引
		IndexReader indexReader = DirectoryReader.open(directory);

		// 5. 创建索引搜索对象(IndexSearcher), 用于执行索引
		IndexSearcher searcher = new IndexSearcher(indexReader);

		/**自定义标注高亮文本标签*/  
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<span style='color:red;font-size:16px'>","</span>");  

		QueryScorer scorer=new QueryScorer(query);  
		/**创建Fragmenter*/  
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);  
		Highlighter highlight=new Highlighter(formatter,scorer);  
		highlight.setTextFragmenter(fragmenter);  


		//创建一个MulitFiledQueryParser对象



		// 6. 使用IndexSearcher对象执行搜索, 返回搜索结果集TopDocs
		// 参数一:使用的查询对象, 参数二:指定要返回的搜索结果排序后的前n个
		TopDocs topDocs = searcher.search(query, 30);
		
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();

		// 7. 处理结果集
		// 7.1 打印实际查询到的结果数量
		System.out.println("实际查询到的结果数量: " + topDocs.totalHits);
		// 7.2 获取搜索的结果数组
		// ScoreDoc中有文档的id及其评分
		
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			System.out.println("= = = = = = = = = = = = = = = = = = =");
			// 获取文档的id和评分
			int docId = scoreDoc.doc;
			float score = scoreDoc.score;
			System.out.println("文档id= " + docId + " , 评分= " + score);
			// 根据文档Id, 查询文档数据 -- 相当于关系数据库中根据主键Id查询数据
			Document doc = searcher.doc(docId);

			Map<String, Object> map=new HashMap<String, Object>();
			map.put("mid", Integer.parseInt(doc.get("mid")));
			map.put("pices", doc.get("pices"));
			map.put("musicaddr", doc.get("musicaddr"));
			map.put("rgdate", doc.get("rgdate"));
			map.put("atname", doc.get("atname"));
			map.put("lyricaddr", doc.get("lyricaddr"));
			map.put("cid", Integer.parseInt(doc.get("cid")));
			map.put("stype", doc.get("stype"));
			map.put("by2", doc.get("by2"));

System.out.println( doc.get("mname")+"--"+doc.get("sgname") );
			String str1="";
			String value =doc.get("mname");  
			if (value != null) {    
				TokenStream tokenStream = analyzer.tokenStream("mname", new StringReader(value));    
				str1 = highlight.getBestFragment(tokenStream, value);    
			}  
			System.out.println("查询出人员:"+str1);  

			if(  str1 != null  && !"null".equals(str1)  ){
				map.put("mname", str1);
			}else{
				map.put("mname", doc.get("mname"));
			}
			
			
			
			String str1s="";
			String values =doc.get("sgname");  
			if (value != null) {    
				TokenStream tokenStreams = analyzer.tokenStream("sgname", new StringReader(values));    
				str1s = highlight.getBestFragment(tokenStreams, values);    
			}   
			System.out.println( str1s );
			if( str1s != null  && !"null".equals(str1s)   ){
				map.put("sgname", str1s);
			}else{
				map.put("sgname", doc.get("sgname"));
			}
			System.out.println(map.get("mname")+"---??---"+map.get("sgname"));
			list.add(map);
			
		}
		indexReader.close();
		return list;
	}

	//返回总数
	public  int check(HttpServletRequest request) {
		IndexReader indexReader = null;
		try {
			Directory directory = FSDirectory.open(new File(tompath));
			indexReader = IndexReader.open(directory);
			// 通过reader可以有效的获取到文档的数量
			int result=indexReader.numDocs();
			// 有效的索引文档
			System.out.println("有效的索引文档:" + indexReader.numDocs());
			// 总共的索引文档
			System.out.println("总共的索引文档:" + indexReader.maxDoc());
			// 删掉的索引文档，其实不恰当，应该是在回收站里的索引文档
			System.out.println("删掉的索引文档:" + indexReader.numDeletedDocs());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (indexReader != null) {
					indexReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static void delete(File file) {
		if(!file.exists()) return;

		if(file.isFile() || file.list()==null) {
			file.delete();
			System.out.println("删除了"+file.getName());
		}else {
			File[] files = file.listFiles();
			for(File a:files) {
				delete(a);					
			}
			file.delete();
			System.out.println("删除了"+file.getName());
		}

	}

}