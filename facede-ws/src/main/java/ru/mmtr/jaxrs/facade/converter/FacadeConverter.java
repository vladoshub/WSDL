package ru.mmtr.jaxrs.facade.converter;

import ru.mmtr.jaxrs.dto.HumanDto;
import ru.mmtr.jaxrs.facadeapi.CriteriaSearch;
import ru.mmtr.jaxrs.facadeapi.HumanDtoWs;
import ru.mmtr.jaxrs.searchcriteria.SearchCriteria;


import java.util.ArrayList;
import java.util.List;

public class FacadeConverter {

    public static HumanDto convertToHumanDto(HumanDtoWs humanDto){
        return new HumanDto(humanDto.getName(),humanDto.getAge(),humanDto.getGrowth(),humanDto.getId());
    }

    public static SearchCriteria convertToSearchCriteria(CriteriaSearch criteriaSearch){
        return new SearchCriteria(criteriaSearch.getName(),criteriaSearch.getAge(),criteriaSearch.getGrowth());
    }

    public static List<HumanDtoWs> convertToHumanDtoWsList(List<HumanDto> humans){
        List<HumanDtoWs> humanDtoWs = new ArrayList<HumanDtoWs>();

        for(HumanDto human:humans) {
            HumanDtoWs humanDtoWs1 = new HumanDtoWs();
            humanDtoWs1.setName(human.getName());
            humanDtoWs1.setAge(human.getAge());
            humanDtoWs1.setGrowth(human.getGrowth());
            humanDtoWs1.setId(human.getId());
            humanDtoWs.add(humanDtoWs1);
        }
        return humanDtoWs;
    }

}
