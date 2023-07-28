package com.thanhnd101.enrich.core.repository;

import com.thanhnd101.enrich.core.entity.Service;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * Service.
 */
@Mapper
public interface ServiceRepository {

  List<Service> findAll(@Param("id") String id, @Param("name") String name, RowBounds rowBounds);

  int count(Service service);

  Long create(Service service);

  Long update(Service service);

  Long delete(@Param("ids") List<Long> ids);

}
