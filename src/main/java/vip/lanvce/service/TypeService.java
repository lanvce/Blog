package vip.lanvce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vip.lanvce.po.Type;

import java.util.List;

/**
 * @author: lanvce$
 * @date: 2020/2/21$ 下午9:28$
 * Description:
 **/
public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id,Type type);

    void deleteType(Long id);
}
