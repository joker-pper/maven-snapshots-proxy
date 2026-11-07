package cn.wlhhd.mavensnapshotsproxy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/proxy")
@Slf4j(topic = "ApiProxyController")
public class ApiProxyController {

    private final RestTemplate restTemplate = buildRestTemplate();

    /**
     * 使用贪婪匹配 {*variable} 来匹配/repository/maven-snapshots/ 之后的所有路径
     *
     * @param remainingPath
     * @return
     */
    @GetMapping("/repository/maven-snapshots/{*remainingPath}")
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<String> proxyGet(@PathVariable("remainingPath") String remainingPath) {
        //构建固定url，不走可传入任意url路径的通用转发，避免高危SSRF。
        return restTemplate.getForEntity("https://central.sonatype.com/repository/maven-snapshots" + remainingPath, String.class);
    }


    private RestTemplate buildRestTemplate() {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(5000);

        factory.setReadTimeout(10000);

        return new RestTemplate(factory);
    }

}
