package com.caoshi.myblogs;

import com.caoshi.myblogs.domain.Article;
import com.caoshi.myblogs.domain.Tag;
import com.caoshi.myblogs.mapper.ArticleMapper;
import com.caoshi.myblogs.mapper.TagMapper;
import com.caoshi.myblogs.service.ArticleService;
import com.caoshi.myblogs.service.TagService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan(basePackages = {"com.caoshi.myblogs.mapper"})
class MyblogsApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TagMapper tagMapper;


    @Test
    void contextLoads() {
        Article article = new Article();
        article.setArticleId(1);
        article.setArticleTitle("JavaSE基础知识");
        article.setArticleUserId(2);
        article.setArticleContent("<h3>JavaSE 基础</h3>\n" +
          "  <h5>（一）HelloWord案例</h5>\n" +
          "  <pre>\n" +
          "    <code>\n" +
          "      public class Test {\n" +
          "        public static void main(String[] args) {\n" +
          "          System.out.println(\"Hello World..\");\n" +
          "        }\n" +
          "      }\n" +
          "    </code>\n" +
          "  </pre>\n" +
          "  <h5>（二）常见的命名规则（见名知意）</h5>\n" +
          "  组成规则：英文大小写字母、数字字符、$和_<br>\n" +
          "  注意事项：不能以数字开头、不能是Java中的关键字、严格区分大小写<br>\n" +
          "  1 包（文件夹）<br>");

        article.setArticleTag("Java");

        int index = articleMapper.insert(article);
        System.out.println(index);

    }

    @Test
    void testService() {
//        List<Article> recoArticles = articleService.getRecoArticles();
//        for (Article recoArticle : recoArticles) {
//            System.out.println(recoArticle);
//        }
        Tag name = tagMapper.selectByPrimaryKey(1);

        System.out.println(name);


    }







}
