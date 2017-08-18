package VO;

import entities.Reader;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ReaderVO {
    private Reader reader;
    private List<FormVO> formVOS = new ArrayList<>();

}
