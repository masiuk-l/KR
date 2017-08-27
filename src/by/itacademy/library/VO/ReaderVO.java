package by.itacademy.library.VO;

import by.itacademy.library.entities.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Project KR. Created by masiuk-l on 17.08.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReaderVO {
    private Reader reader;
    private List<FormVO> formVOS = new ArrayList<>();

}
