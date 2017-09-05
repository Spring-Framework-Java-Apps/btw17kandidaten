package org.woehlke.btw17.kandidaten.support.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.support.oodm.repositories.JdbcRepository;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
public class JdbcServiceImpl implements JdbcService {

    private final JdbcRepository jdbcRepository;

    @Autowired
    public JdbcServiceImpl(JdbcRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    @Override
    public void executeSqlStatemen(String sql) {
        jdbcRepository.executeSqlStatemen(sql);
    }
}
