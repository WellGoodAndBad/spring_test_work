package com.textparser.textparser;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;


@Component
public class HtmlParser {
    @Value("${userAgent}")
    private String userAgent;

    @Value("${url}")
    private String url;

    public String getUserAgent() {
        return userAgent;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getHtml() throws Exception {
        Document doc = Jsoup.connect(getUrl()).userAgent(getUserAgent()).get();
        Elements elements = doc.select("div.article__text");
        ArrayList<String> list = new ArrayList<String>();
        for (Element element : elements) {
            list.add(element.ownText());
        }
        return list;
    }
}
