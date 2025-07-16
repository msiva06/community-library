package com.community_library.community_info.repository;

import com.community_library.community_info.model.Community;
import com.community_library.community_info.model.CommunityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityInfoRepository extends JpaRepository<Community,Short> {
    List<Community> findByCommunityType(CommunityType communityType);
}
