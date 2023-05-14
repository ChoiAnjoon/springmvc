package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * GET /mapping/users
     * 회원목록조회
     */
    @GetMapping
    public String user() {
        return "get users";
    }

    /**
     * POST /mapping/users
     * 회원등록
     */
    @PostMapping
    public String addUser() {
        return "post user";
    }

    /**
     * GET /mapping/users/{userId}
     * 회원 한명 조회
     */
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userID = " + userId;
    }

    /**
     * PATCH /mapping/users/{userId}
     * 회원 수정
     */
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userID = " + userId;
    }

    /**
     * DELETE /mapping/users/{userId}
     * 회원 삭제
     */
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userID = " + userId;
    }
}
