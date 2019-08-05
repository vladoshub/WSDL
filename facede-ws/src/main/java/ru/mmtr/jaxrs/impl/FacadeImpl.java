package ru.mmtr.jaxrs.impl;

import ru.mmtr.jaxrs.converters.FacadeConverter;
import ru.mmtr.jaxrs.service.ServiceApi;
import ru.mmtr.jaxrs.webservice.*;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "FacadeService", portName = "FacadePort", name = "Facade",
        endpointInterface = "ru.mmtr.jaxrs.webservice.Facade", targetNamespace = "http://webservice.jaxrs.mmtr.ru")
public class FacadeImpl implements Facade {

    @EJB
    private ServiceApi serviceApi;

    @Override
    @WebMethod
    public List<HumanDtoWs> getHumanDto(CriteriaSearch criteriaSearch) {
        return FacadeConverter.convertToHumanDtoWsList(serviceApi.getHumansByParams(FacadeConverter.convertToSearchCriteria(criteriaSearch)));
    }

    @Override
    @WebMethod
    public void addHuman(HumanDtoWs humanDto) {
             serviceApi.addHuman(FacadeConverter.convertToHumanDto(humanDto));
    }
}
