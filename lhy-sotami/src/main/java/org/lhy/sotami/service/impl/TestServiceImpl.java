package org.lhy.sotami.service.impl;

import org.lhy.sotami.primary.bean.PrimaryTest;
import org.lhy.sotami.primary.repository.TestPrimaryRepository;
import org.lhy.sotami.secondary.bean.SecondaryTest;
import org.lhy.sotami.secondary.repository.TestSecondaryRepository;
import org.lhy.sotami.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/12/19 5:49 PM
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestSecondaryRepository secondaryRepository;

    @Autowired
    private TestPrimaryRepository primaryRepository;

    @Override
    public void test() {
        List<SecondaryTest> setestLists = secondaryRepository.findAll();
        List<PrimaryTest> primaryTests = primaryRepository.findAll();
        System.out.println(setestLists.toString());
        System.out.println(primaryTests.toString());
    }
}
