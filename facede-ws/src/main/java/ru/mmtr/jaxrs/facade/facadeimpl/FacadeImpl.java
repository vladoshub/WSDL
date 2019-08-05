package ru.mmtr.jaxrs.facade.facadeimpl;

import ru.mmtr.jaxrs.facade.converter.FacadeConverter;
import ru.mmtr.jaxrs.facadeapi.CriteriaSearch;
import ru.mmtr.jaxrs.facadeapi.Facade;
import ru.mmtr.jaxrs.facadeapi.HumanDtoWs;
import ru.mmtr.jaxrs.service.ServiceApi;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebEndpoint;
import java.util.List;

@WebService(serviceName = "FacadeService",portName = "FacadePort", name = "Facade",
        endpointInterface = "ru.mmtr.jaxrs.facadeapi.Facade", targetNamespace = "http://facadeapi.jaxrs.mmtr.ru")
public class FacadeImpl implements Facade {

    @EJB
    private ServiceApi serviceApi;

    @Override
    public List<HumanDtoWs> getHumanDto(CriteriaSearch criteriaSearch) {
        return FacadeConverter.convertToHumanDtoWsList(serviceApi.getHumansByParams(FacadeConverter.convertToSearchCriteria(criteriaSearch)));
    }

    @Override
    public void addHuman(HumanDtoWs humanDto) {
             serviceApi.addHuman(FacadeConverter.convertToHumanDto(humanDto));
    }
}
