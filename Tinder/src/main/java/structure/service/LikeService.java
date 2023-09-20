package structure.service;

import structure.domain.Profile;

import java.util.List;

public interface LikeService {
    void addLike(long userid, long likedId);

    List<Profile> findLiked(long userId);

    void deleteAllLikes(long userId);
}
