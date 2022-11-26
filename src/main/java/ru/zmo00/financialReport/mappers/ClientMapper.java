package ru.zmo00.financialReport.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import ru.zmo00.financialReport.models.entities.Client;
import ru.zmo00.financialReport.openAPI.model.NewClient;

@Mapper
@Service
public interface ClientMapper {
    Client toClientEntity(NewClient newClient);
    ru.zmo00.financialReport.openAPI.model.Client toClientOpenAPI(Client client);
}
