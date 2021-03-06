package app;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(@Param("name") String name);

}