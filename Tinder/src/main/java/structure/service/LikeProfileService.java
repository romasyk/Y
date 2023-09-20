package structure.service;

import structure.dao.LikeDao;
import structure.domain.Profile;

import java.util.List;

public class LikeProfileService implements LikeService{
   private final LikeDao likeDao;

   @Override
   public void addLike(long userid, long likedId){
       likeDao.addLike(userid, likedId);
   }
@Override
    public List<Profile> findLiked(long userId){
       return likeDao.findLiked(userId);
    }
@Override
public void deleteAllLikes(long userId){
       likeDao.deleteAllLikes(userId);
}

    public LikeProfileService(LikeDao likeDao) {
        this.likeDao = likeDao;
    }
}
