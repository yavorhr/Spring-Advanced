package bg.softuni.cloudinary.repository;

import bg.softuni.cloudinary.model.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity, Long> {

  void deleteAllByPublicId(String publicId);

}
