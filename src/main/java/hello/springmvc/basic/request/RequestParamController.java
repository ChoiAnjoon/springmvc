package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);
        response.getWriter().write("ok");
    }

    @ResponseBody // Http응답 메세지 바디에 ok를 문자열로 넣어서 박아줌
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, // 요청파라미터와 같은 name이어야 한다.
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) { // 요청파라미터와 같은 name이어야 한다.

        log.info("username={}, age={}", username, age);
        return "ok";
    }
    // String, int, Integer 등의 단순 타입이면 @RequestParam도 생략가능
    // 그런데 너무 없는것도 좀 과하다는 생각이 있다 @RequestParam을 쓰는걸 권장..

    // 필수 파라미터 여부 세팅
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, // 무조껀 username이 파라미터로 들어와야함
            @RequestParam(required = false) Integer age) { // age는 파라미터로 안들어와도됨 (null이 들어갈수 있는 Integer로 형을 fix해 주어야함)

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, // username이 ""(빈 문자열일때) 디폴트로 guest를 넣음
            @RequestParam(required = false, defaultValue = "-1") int age) { // 디폴트value -1을 지정해주면 int형을 쓸수 있음
        // 사실 defaultValue가 들어가면 required는 있든 없든 상관이 없다.

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
//        log.info("helloData={}", helloData);
//
//        return "ok";
    // 원래는 이런식으로 했다면 밑에와 같이 바꿀 수 있다. 코드가 정말 간소화 된다.

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData); // ToString 으로 나온다. Lombok으로 만들었기 때문
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) { //@ModelAttribute 생략 가능

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);
        return "ok";
    }
}
