package cn.wilmar.demo.web;

import cn.wilmar.demo.mapper.RoleMapper;
import cn.wilmar.demo.model.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleMapper roleMapper;

    public RoleController(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @GetMapping("/getAllRoles")
    public List<Role> getAll() {
        return roleMapper.selectAll();
    }
}
