package com.example.demo.service.impl;

import com.example.demo.entity.TManagerUser;
import com.example.demo.mapper.TManagerUserMapper;
import com.example.demo.service.ITManagerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wayne
 * @since 2020-03-18
 */
@Service
public class TManagerUserServiceImpl extends ServiceImpl<TManagerUserMapper, TManagerUser> implements ITManagerUserService {

}
