package com.yjgs.bll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;

import com.yjgs.controller.news.ManagerNewsSel;
import com.yjgs.dal.NewsDal;
import com.yjgs.dal.NewsTypeDal;
import com.yjgs.dcl.News;
import com.yjgs.dcl.NewsType;

public class NewsTypeBll {

	// 添加新闻类别
	public boolean AddNewsType(NewsType fNewsType) {

		// 调用数据访问层，返回添加结果
		NewsTypeDal nDal = new NewsTypeDal();

		return nDal.addNewsType(fNewsType);
	}

	// 管理员页面加载所有新闻类型，对数据进行修改和删除
		public void onloadNewsType(JspWriter fout) throws IOException {

			NewsTypeDal nDal = new NewsTypeDal();
			ArrayList<NewsType> newsTypeList = null;
			newsTypeList = new ArrayList<NewsType>();
			String TypeName = null;
			String PName = null;
			String updateName = null;
			String button = null;

			try {
				// 获取所有类别数据动态数组
				newsTypeList = nDal.getAllNewsType();
				// 加载数据到jsp页面
				fout.println("<form action='UpdateNewsTypeSel' method='post'>");
				fout.print("<table class='center'>");
				fout.print("<caption>新闻类别管理</caption><thead><tr><th class='number'>编号</th><th class='typeName'>类别名称</th><th class='modify'>修改</th><th class='delete'>删除</th></tr></thead>");
				fout.print("<tbody>");
				if (newsTypeList.size() != 0) {
					for (int t = 0; t < newsTypeList.size(); t++) {

						TypeName = String.format("TypeName%d", t);
						PName = String.format("Name%d", t);
						updateName = String.format("Update%d", t);
						button = String.format("button%d", t);

						fout.print(String.format(
								"<input type='hidden' name='id' value=%d />",
								newsTypeList.get(t).getTypeID()));
						fout.print(String
								.format("<td>%d</td><td id='%s'>"
										+ "%s</td>"
										+ "<td class='modifyTd' ><a style='color:#1169BF' href='#' onclick='updateType(this,%d);return false'>修改</a></td>"
										+ "<td class='deleteTd'><a onclick='return sureDelete();' href='DeleteNewsTypeSel?id=%d'>删除</a></td></tr>",
										t + 1, TypeName, newsTypeList.get(t)
												.getTypeName(),
												newsTypeList.get(t).getTypeID(),
										newsTypeList.get(t).getTypeID()));

					}
				}
				fout.print("</tbody></table>");
				fout.print("</form>");
			} catch (Exception e) {

				System.out.print("新闻类别查询出错！");
				e.printStackTrace();
			}

		}


	// 修改新闻类别
	public boolean UpdateTypeName(NewsType fNewsType) {

		NewsTypeDal tnDal = new NewsTypeDal();

		return tnDal.updateNewsType(fNewsType);
	}

	// 删除新闻类别
	public boolean DeleteTypeName(NewsType fNewsType) {

		NewsTypeDal tnDal = new NewsTypeDal();

		return tnDal.deleteNewsType(fNewsType);
	}

	// 加载新闻类别
	public void loadNewsType(JspWriter fout) {

		NewsTypeDal tnDal = new NewsTypeDal();

		ArrayList<NewsType> types = new ArrayList<NewsType>();

		try {
			// 查询所有新闻类别
			types = tnDal.getAllNewsType();

			// 通过循环输出数据
			fout.print("<select name='NewsType'>");
			for (int t = 0; t < types.size(); t++) {
				fout.print(String.format("<option value=%d>%s</option>", types
						.get(t).getTypeID(), types.get(t).getTypeName()));
			}
			fout.print("</select>");

		} catch (Exception e) {
			System.out.print("新闻类别加载失败！");
			e.printStackTrace();
		}

	}

	// 加载所有新闻类别
	public void loadAllNewsType(JspWriter fout) {

		NewsTypeDal tnDal = new NewsTypeDal();

		ArrayList<NewsType> types = new ArrayList<NewsType>();

		try {

			// 步骤1：通过getAllNewsType()函数获取所有新闻类型
			types = tnDal.getAllNewsType();
			fout.println("<li><a href='ShowTypeNews.jsp?typeID=0' >所有新闻</a></li>");
			// 步骤2：通过循环语句，用列表的形式，加载所有新闻类型
			for (int t = 0; t < types.size(); t++) {
				fout.print(String.format(
						"<li><a href='ShowTypeNews.jsp?typeID=%d'>%s</a></li>",
						types.get(t).getTypeID(), types.get(t).getTypeName()));
			}

		} catch (Exception e) {
			System.out.print("新闻类别加载失败！");
			e.printStackTrace();
		}

	}

	/**
	 * 加载相应新闻列别的所有新闻
	 * 
	 * @param fTypeID
	 *            新闻列别ID
	 * @param fout
	 *            jsp页面输出out
	 */

	public void LoadAllNews(int fTypeID, JspWriter fout, int fpage) {

		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (fTypeID != 0) {
			// //步骤1：实例化新闻类型实体类，填充ID数据，并实例化数据访问层和动态新闻数组

			NewsType newsType = new NewsType();
			newsType.setTypeID(fTypeID);

			News news2 = new News();
			news2.setTypeID(fTypeID);

			NewsTypeDal newsTypeDal = new NewsTypeDal();

			NewsDal newsDal = new NewsDal();

			ArrayList<News> news = new ArrayList<News>();

			try {
				news = newsDal.getList(news2, fpage);
				// 数据为空处理
				if (news==null) {
					fout.println("<p class='errorMessage'>该系列暂无新闻！</p>");
				} else {
					// 步骤3：执行getNewsType()函数，获取对应系列名称
					newsType = newsTypeDal.getNewsType(newsType);

					fout.println("<table><thead><tr>");
					fout.println(String
							.format("<th class='newstitle'>新闻标题</th><th class='publishtime'>发布时间</th></tr></thead><tbody id='tbfortr'>",
									newsType.getTypeName()));
					for (int t = 0; t < news.size(); t++) {
						fout.println(String
								.format("<tr><td class='tdtitle'><a href='ShowNews.jsp?newsID=%d'>%s</a></td><td class='tdtime'>%s</td></tr>",
										news.get(t).getNewsID(), news.get(t)
												.getTitle(), dFormat
												.format(news.get(t)
														.getPublishTime())));
					}
					fout.println("</tbody></table>");
				}

			} catch (Exception e) {
				System.out.println("新闻数据显示出错！");
				e.printStackTrace();
			}
		} else {
			News news2 = new News();
			news2.setTypeID(fTypeID);

			NewsTypeDal newsTypeDal = new NewsTypeDal();

			NewsDal newsDal = new NewsDal();
			ArrayList<News> news = new ArrayList<News>();

			try {

				news = newsDal.getList(news2, fpage);
				// 数据为空处理
				if (news== null) {
					fout.println("<p class='errorMessage'>该系列暂无新闻！</p>");
				} else {
					fout.println("<table><thead><tr>");
					fout.println("<th class='newstitle'>新闻标题</th><th class='publishtime'>发布时间</th></tr></thead><tbody id='tbfortr'>");
					for (int t = 0; t < news.size(); t++) {
						fout.println(String
								.format("<tr><td class='tdtitle'><a href='ShowNews.jsp?newsID=%d'>%s</a></td><td class='tdtime'>%s</td></tr>",
										news.get(t).getNewsID(), news.get(t)
												.getTitle(), dFormat
												.format(news.get(t)
														.getPublishTime())));
					}

					fout.println("</tbody></table>");
				}
			} catch (Exception e) {
				System.out.println("新闻数据显示出错！");
				e.printStackTrace();
			}
		}

	}

	// 加载管理员相应系列所有新闻,正常执行
	public void LoadManagerAllNews(int fTypeID, JspWriter fout) {

		// 步骤1：实例化新闻类型实体类，填充ID数据，并实例化数据访问层和动态新闻数组
		NewsType newsType = new NewsType();
		newsType.setTypeID(fTypeID);

		NewsTypeDal newsTypeDal = new NewsTypeDal();
		ArrayList<News> news = new ArrayList<News>();
		try {

			// 步骤2：执行getTypeNews()函数，获取对应系列所有新闻的动态数组
			news = newsTypeDal.getTypeNews(newsType);

			// 步骤3：执行getNewsType()函数，获取对应系列名称
			newsType = newsTypeDal.getNewsType(newsType);

			// 步骤4：通过一个循环，用表格的形式，输出数据
			fout.println(String.format("<h2>%s系列有如下新闻</h2>",
					newsType.getTypeName()));
			fout.println("<table>");
			fout.println("<tr><th>标题</th><th>发布时间</th></tr>");
			for (int t = 0; t < news.size(); t++) {
				fout.println(String
						.format("<tr><td><a href='UpdateNews.jsp?newsID=%d'>%s</a></td><td>%s</td></tr>",
								news.get(t).getNewsID(),
								news.get(t).getTitle(), news.get(t)
										.getPublishTime()));
			}
			// 数据为空处理
			if (news.size() == 0) {
				fout.print("暂无此系列新闻！");
			}
			fout.println("</table>");
		} catch (Exception e) {

			System.out.print("加载新闻出错！");
			e.printStackTrace();
		}
	}

	// 加载管理员管理页面新闻类别
	public void loadManagerNewsType(JspWriter fout) {

		NewsTypeDal tnDal = new NewsTypeDal();

		ArrayList<NewsType> types = new ArrayList<NewsType>();

		try {

			// 执行getAllNewsType()函数，获取所有新闻类别动态数组数据
			types = tnDal.getAllNewsType();

			String[] NewsSums = getNewsTypeSum(types);
			// 加载数据，输出到jsp页面

			fout.print("<table>");
			for (int t = 0; t < types.size(); t++) {
				fout.print(String
						.format("<tr><td><a href='ManagerNews.jsp?typeID=%d'>%s(%s)</a></td></tr>",
								types.get(t).getTypeID(), types.get(t)
										.getTypeName(), NewsSums[t]));
				// =======
				//
				// // 执行getAllNewsType()函数，获取所有新闻类别动态数组数据
				// types = tnDal.getAllNewsType();
				//
				// // 加载数据，输出到jsp页面
				// fout.print("<form id='typeOptions' class='newType' action='ManagerNewsSel' method='post'>");
				// fout.print("<span>新闻类型：</span><select name='NewsType' id='NewsType'>");
				// for (int t = 0; t < types.size(); t++) {
				// fout.print(String.format("<option value=%d>%s</option>",
				// types
				// .get(t).getTypeID(), types.get(t).getTypeName()));
				// >>>>>>> .r244
			}
			fout.print("</table>");

			fout.print("</select>");
			// fout.print("<input class='chakan' type='submit' value='查看'>");
			fout.print("</form>");

		} catch (Exception e) {
			System.out.print("新闻类别加载失败！");
			e.printStackTrace();
		}
	}

	// 加载管理员页面首次加载相应新闻类别的所有数据,异常执行
	public void LoadFirstManagerAllNews(JspWriter fout) {

		NewsTypeDal newsTypeDal = new NewsTypeDal();
		ArrayList<NewsType> newsTypes = new ArrayList<NewsType>();
		// 步骤1：获取相应新闻ID
		newsTypes = newsTypeDal.getAllNewsType();

		// 步骤2：填充数据到实体类
		NewsType newsType = new NewsType();
		newsType.setTypeID(newsTypes.get(0).getTypeID());
		ArrayList<News> news = new ArrayList<News>();
		try {

			// 步骤3：获取相应新闻类别的所有新闻动态数组
			news = newsTypeDal.getTypeNews(newsType);

			// 步骤4：获取相应新闻类别名字
			newsType = newsTypeDal.getNewsType(newsType);

			// 步骤5：通过循环输出数据到jsp页面上
			fout.println(String.format("<h2>%s系列有如下新闻：</h2>",
					newsType.getTypeName()));
			fout.println("<table>");
			for (int t = 0; t < news.size(); t++) {
				fout.println(String
						.format("<tr><td><a href='UpdateNews.jsp?newsID=%d'>%s</a></td><td>%s</td></tr>",
								news.get(t).getNewsID(),
								news.get(t).getTitle(), news.get(t)
										.getPublishTime()));
			}
			if (news.size() == 0) {
				fout.println("该新闻类别暂无新闻！");
			}
			fout.println("</table>");
		} catch (Exception e) {

			System.out.print("加载新闻出错！");
			e.printStackTrace();
		}
	}

	public String[] getNewsTypeSum(ArrayList<NewsType> fNewsTypes) {

		NewsTypeDal ntDal = new NewsTypeDal();
		NewsType newsType = new NewsType();
		ArrayList<News> newsList = new ArrayList<News>();
		String[] sums = new String[10];
		int t = 0;

		try {

			for (t = 0; t < fNewsTypes.size(); t++) {
				newsType.setTypeID(fNewsTypes.get(t).getTypeID());
				try {
					newsList = ntDal.getTypeNews(newsType);
				} catch (Exception e) {
					System.out.println("查询对应系列新闻数量出错！");
					e.printStackTrace();
				}
				try {

					System.out.println(newsList.size());
					if (newsList == null) {
						sums[t] = "0";
					} else
						sums[t] = String.valueOf(newsList.size());

				} catch (Exception e) {
					System.out.println("新闻数量为零！");
					e.printStackTrace();
				}

			}
		} catch (Exception e) {

			System.out.println("查询对应系列新闻数量出错！");
			e.printStackTrace();
		}
		return sums;
	}
}
