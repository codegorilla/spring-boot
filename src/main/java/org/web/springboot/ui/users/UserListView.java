package org.web.springboot.ui.users;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;
import org.web.springboot.model.User;
import org.web.springboot.service.UserService;

@Route("users")
@PageTitle("Users")
@PermitAll
public class UserListView extends VerticalLayout {

  public UserListView(UserService userService) {
    Grid<User> grid = new Grid<>(User.class, false);
    grid.addColumn(User::getFirstName).setHeader("First Name").setSortable(true);
    grid.addColumn(User::getLastName).setHeader("Last Name").setSortable(true);
    grid.addColumn(User::getEmailAddress).setHeader("Email Address");
    grid.addColumn(u -> u.getUserProfile().getOrganization()).setHeader("Organization");
    grid.addColumn(u -> u.getUserProfile().getDepartment().getName()).setHeader("Department");
//    grid.addComponentColumn(u -> new Button("View Details",
//        e -> e.getSource().getUI().ifPresent(ui ->
//          ui.navigate(UserDetailView.class, u.getId()))))
//      .setHeader("Actions");

    grid.setItems(userService.getUsers());
    add(new H2("Users"), grid);
    setSizeFull();
  }
}
