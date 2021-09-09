package com.example.application.data.endpoint;

import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;

import java.util.List;
import java.util.Optional;

import com.vaadin.fusion.Endpoint;

import org.vaadin.artur.helpers.GridSorter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.PagingUtil;

import com.vaadin.fusion.Nonnull;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class SamplePersonEndpoint {

    private SamplePersonService service;

    public SamplePersonEndpoint(@Autowired SamplePersonService service) {
        this.service = service;
    }

    @Nonnull
    public List<@Nonnull SamplePerson> list(int pageNumber, int pageSize, @Nonnull List<@Nonnull Order> orders) {
        Pageable request = PageRequest.of(pageNumber, pageSize, Sort.by(orders));
        return service.list(request).getContent();
    }

    public Optional<SamplePerson> get(@Nonnull Integer id) {
        return service.get(id);
    }

    @Nonnull
    public SamplePerson update(@Nonnull SamplePerson entity) {
        return service.update(entity);
    }

    public void delete(@Nonnull Integer id) {
        service.delete(id);
    }

    public int count() {
        return service.count();
    }

}
