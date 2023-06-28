package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * 회원목록조회 :    GET /mapping/users
     * 회원등록 :       POST /mapping/users
     * 회원 한명 조회 :  GET /mapping/users/{userId}
     * 회원 수정 :      PATCH /mapping/users/{userId}
     * 회원 삭제 :      DELETE /mapping/users/{userId}
     */
    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userID = " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userID = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userID = " + userId;
    }
}
