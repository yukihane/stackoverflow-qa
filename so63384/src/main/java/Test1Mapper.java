import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

// null の場合は上書きせずもとの値を維持したいので IGNORE を指定
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Test1Mapper {
    Test1Mapper INSTANCE = Mappers.getMapper(Test1Mapper.class);

    void merge(Test1 merging, @MappingTarget Test1 merged);
}