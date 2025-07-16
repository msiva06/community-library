package com.community_library.community_info.controller;

import com.community_library.community_info.model.Community;
import com.community_library.community_info.model.CommunityType;
import com.community_library.community_info.service.CommunityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CommunityInfoController {

    @Autowired
    private CommunityInfoService communityInfoService;

    @Value("${app.name}")
    private String applicationName;

    @PostMapping(value = "/communityInfo", consumes = "application/json")
    public ResponseEntity<Short> save(@RequestBody CommunityDTO communityDTO) {
        Community community = new Community();
        community.setCommunityName(communityDTO.getCommunity_Name());
        if (communityDTO.getCommunityType().equals("APARTMENTS")) {
            community.setCommunityType(CommunityType.APARTMENTS);
        } else if (communityDTO.getCommunityType().equals("CONDOS")){
            community.setCommunityType(CommunityType.CONDOS);
        } else if (communityDTO.getCommunityType().equals( "TOWNHOMES")) {
            community.setCommunityType(CommunityType.TOWNHOMES);
        } else if (communityDTO.getCommunityType().equals("INDIVIDUAL HOMES")) {
            community.setCommunityType(CommunityType.INDIVIDUAL_HOMES);
        }

        community.setCommunityManagerId(communityDTO.getCommunityManagerId());
        community.setCity(communityDTO.getCity());
        community.setState(communityDTO.getState());
        community.setActiveIndicator('Y');
        if (!communityDTO.isActiveIndicator()) {
            community.setActiveIndicator('N');
        }
        community.setZip(communityDTO.getZip());
        community.setZip4(communityDTO.getZip4());
        community.setCreatedBy(applicationName);

        Date curr = new Date();
        Timestamp created = new Timestamp(curr.getTime());
        community.setCreatedTimestamp(created);
        Community createdResponse = communityInfoService.save(community);
        return new ResponseEntity<>(createdResponse.getCommunityId(), HttpStatus.CREATED);
    }


    @GetMapping("/communityInfo/{communityType}")
    public ResponseEntity<List<Community>> findByCommunityType(@PathVariable("communityType") String communityType){
        List<Community> commList = new ArrayList<>();
        if(communityType.equals("APARTMENTS")){
            commList = communityInfoService.findByCommunityType(CommunityType.APARTMENTS);
        }
        else if(communityType.equals("TOWNHOMES")){
            commList = communityInfoService.findByCommunityType(CommunityType.TOWNHOMES);
        }
        else if(communityType.equals("CONDOS")){
            commList = communityInfoService.findByCommunityType(CommunityType.CONDOS);
        }

        if(commList.size() > 0){
            return new ResponseEntity<>(commList,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(commList,HttpStatus.NO_CONTENT);
        }

    }

    @PutMapping(value = "/communityInfo" ,consumes = "application/json")
    public ResponseEntity<Community> update(@RequestBody CommunityDTO communityDTO){
        Community community = communityInfoService.findByCommunityId(communityDTO.getCommunityId()).get();
        System.out.println("FindBy community:" + community);
        System.out.println("Community DTO:" + communityDTO);
        community.setCommunityName(communityDTO.getCommunity_Name());
        if (communityDTO.getCommunityType().equals("APARTMENTS")) {
            community.setCommunityType(CommunityType.APARTMENTS);
        } else if (communityDTO.getCommunityType().equals("CONDOS")){
            community.setCommunityType(CommunityType.CONDOS);
        } else if (communityDTO.getCommunityType().equals( "TOWNHOMES")) {
            community.setCommunityType(CommunityType.TOWNHOMES);
        } else if (communityDTO.getCommunityType().equals("INDIVIDUAL HOMES")) {
            community.setCommunityType(CommunityType.INDIVIDUAL_HOMES);
        }

        community.setCommunityManagerId(communityDTO.getCommunityManagerId());
        community.setCity(communityDTO.getCity());
        community.setState(communityDTO.getState());
        community.setActiveIndicator('Y');
        if (!communityDTO.isActiveIndicator()) {
            community.setActiveIndicator('N');
        }
        community.setZip(communityDTO.getZip());
        community.setZip4(communityDTO.getZip4());
        community.setUpdatedBy(applicationName);

        Date curr = new Date();
        Timestamp updated = new Timestamp(curr.getTime());
        community.setUpdatedTimestamp(updated);
        Community updatedResponse = communityInfoService.save(community);
        return new ResponseEntity<>(updatedResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/communityInfo/{communityId}")
    public ResponseEntity<Short> deleteByCommunityId(@PathVariable short communityId){
        communityInfoService.deleteByCommunityId(communityId);
        return new ResponseEntity<>(communityId,HttpStatus.OK);
    }
}
