package com.fairwaysoftware.lms.service;

import com.fairwaysoftware.lms.repository.LeagueMemberRepository;
import com.fairwaysoftware.lms.repository.entity.LeagueMemberEntity;
import com.fairwaysoftware.lms.service.domain.LeagueMember;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
public class LeagueMemberService {

    private LeagueMemberRepository repository;
    private ModelMapper modelMapper;

    public List<LeagueMember> findByLeagueId(Integer leagueId) {
        return repository.findByLeagueId(leagueId).stream()
                .map(e -> modelMapper.map(e, LeagueMember.class))
                .collect(Collectors.toList());
    }

    public List<LeagueMember> findByUserId(Integer userId) {
        return repository.findByUserId(userId).stream()
                .map(e -> modelMapper.map(e, LeagueMember.class))
                .collect(Collectors.toList());
    }

    public Optional<LeagueMember> findById(Integer id) {
        return repository.findById(id)
                .map(e -> modelMapper.map(e, LeagueMember.class));
    }

    @Transactional
    public LeagueMember save(@Valid LeagueMember domain) {
        LeagueMemberEntity entity = modelMapper.map(domain, LeagueMemberEntity.class);
        entity = repository.save(entity);
        return modelMapper.map(entity, LeagueMember.class);
    }

}