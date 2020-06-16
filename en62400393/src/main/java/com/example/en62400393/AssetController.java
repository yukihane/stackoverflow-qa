package com.example.en62400393;

import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private ResourcePatternResolver resolver;

    @GetMapping("")
    @ResponseBody
    public String resources() throws IOException {
        final String root = resolver.getResource("classpath:/static/assets").getURI().toString();

        final Resource[] resources = resolver
            .getResources("classpath:/static/assets/**/*.png");
        final List<String> fileNames = Stream.of(resources)
            .filter(
                Resource::isFile)
            .map(r -> {
                try {
                    return r.getURI().toString().replace(root, "");
                } catch (final IOException e) {
                    throw new IOError(e);
                }
            })
            .collect(Collectors.toList());

        final StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<ul>");
        for (final String fileName : fileNames) {
            html.append("<li>");
            html.append("<a href=\"/assets" + fileName + "\">" + fileName + "</a>");
            html.append("</li>");
        }
        html.append("</ul>");
        html.append("</html>");
        return html.toString();
    }

}
