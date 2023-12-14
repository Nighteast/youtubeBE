package com.example.pj2be.service.adminservice;

import com.example.pj2be.domain.page.PageDTO;
import com.example.pj2be.domain.page.PaginationDTO;
import com.example.pj2be.mapper.adminmapper.AdminMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminMemberService {

    private final AdminMemberMapper mapper;

    public Map<String, Object> memberlist(Integer page, String mid) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> pageInfo = new HashMap<>();

        // 페이징 필요한 것들
        // 전체페이지, 보여줄페이지 수, 왼쪽끝페이지, 오른쪽끝페이지, 담페이지, 이전페이지,
        int countAll;

        countAll = mapper.selectAll("%" + mid + "%");

        int lastPageNumber = (countAll - 1) / 20 + 1;
        int startPageNumber = (page - 1) / 20 * 20 + 1;
        int endPageNumber = (startPageNumber + (20 - 1));
        endPageNumber = Math.min(endPageNumber, lastPageNumber);
        int prevPageNumber = startPageNumber - 20;
        int nextPageNumber = endPageNumber + 1;
        int initialPage = 1;

        // 넘겨줄 것들 put

        pageInfo.put("currentPageNumber", page);
        pageInfo.put("startPageNumber", startPageNumber);
        pageInfo.put("endPageNumber", endPageNumber);

        if (prevPageNumber > 0) {
            pageInfo.put("prevPageNumber", prevPageNumber);
            pageInfo.put("initialPage", initialPage);
        }
        if (nextPageNumber <= lastPageNumber) {
            pageInfo.put("nextPageNumber", nextPageNumber);
            pageInfo.put("lastPageNumber", lastPageNumber);
        }

        int from = (page - 1) * 20;
        map.put("pageInfo", pageInfo);

        map.put("memberList", mapper.selectAllMember(from, "%" + mid + "%"));
        return map;
    }

    public Map<String, Object> memberInfo(String memberId, Integer page, PaginationDTO paginationDTO) {
        Map<String, Object> map = new HashMap<>();

        // 활동한 게시판목록
        map.put("activeBoard", mapper.selectActiveBoard(memberId));

        // 멤버정보 가져오기
        map.put("memberList", mapper.selectByMemberId(memberId));


        // 작성한 댓글 가져오기
        map.put("memberInfoCommentList", mapper.selectCommentList(memberId));

        // 게시물 페이징
        paginationDTO.setAllPage(mapper.selectAllMemberBoard(memberId));
        paginationDTO.setCurrentPageNumber(page);
        paginationDTO.setLimitList(20);

        map.put("pageInfo", paginationDTO);
        System.out.println("paginationDTO = " + paginationDTO);

        // 작성한 게시글 가져오기
        map.put("memberInfoBoardList", mapper.selectBoardList(memberId, paginationDTO));
        // 댓글 페이징
//        PageDTO pageDTO2 = new PageDTO();
//        pageDTO2.setPage(page);
//        pageDTO2.setTotalList(mapper.selectAllMemberComment(memberId));
//        pageDTO2.setLimitList(30);
//
//        map.put("pageInfo2", pageDTO2);

        return map;
    }
}
