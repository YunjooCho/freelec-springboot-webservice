package com.yjcho.springboot.service.posts;


import com.yjcho.springboot.domain.posts.Posts;
import com.yjcho.springboot.domain.posts.PostsRepository;
import com.yjcho.springboot.web.dto.PostSaveRequestDto;
import com.yjcho.springboot.web.dto.PostsListResponseDto;
import com.yjcho.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  //javax는 readOnly가 안먹힘


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //@Autowired대신 사용(Bean 주입)
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostSaveRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        //postsRespository에서 넘어온 Posts(엔티티객체)의 Stream을
        //map을 통해 PostsListResponseDto로 변환 > 다시 Lists로 변환
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) //.map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts post = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));

        postsRepository.delete(post);
    }

}
