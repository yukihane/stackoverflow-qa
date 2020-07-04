package com.example.en62724909;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService service;

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("mm/DD/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
            dateFormat, false));
    }

    @RequestMapping(value = "/list-todo", method = RequestMethod.GET)
    // HttpSession allows access to the session
    public String showToDo(final ModelMap model, final HttpSession httpSession) {
        final String user = (String) httpSession.getAttribute("name");
        model.addAttribute("todos", service.retrieveTodos(user));
        return "list-todos";
    }

    // redirect to update form
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String getUpdateForm(final ModelMap model, @RequestParam final int id) {
        // To work with command bean
        model.addAttribute("todo", service.retrieveTodo(id));
        model.clear();
        return "updateToDo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String submitUpdate(final ModelMap model, @Valid final ToDo todo, final BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/update-todo";
        }
        service.updateToDo(todo);
        model.clear();
        return "redirect:/list-todo";
    }

    // Will be executed first
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddForm(final ModelMap model) {
        model.addAttribute("todo", new ToDo());
        return "addToDo";
    }

    /*
     * Will be executed after form is submitted
     * @Valid ToDo - command bean from addToDo.jsp.
     * @Valid to validate the information
     * @BindingResult showcases the result of the validation
     */
    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String submitAddForm(final ModelMap model, @Valid final ToDo todo, final HttpSession httpSession,
        final BindingResult result) {
        System.out.println("running" + result);
        // If there is validation error , return to addToDos page for user to fix the error
        if (result.hasErrors()) {
            return "redirect:/showAddForm";
        }
        final String user = (String) httpSession.getAttribute("name");
        service.addTodo(user, todo.getDescription(), todo.getTargetDate(), false);
        // Clears the url e.g. name?=jyj123
        model.clear();
        // return to the url which executes the showToDO
        return "redirect:/list-todo";
}

// delete to do entry
@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
public String deleteToDo(final ModelMap model, @RequestParam final int id) {
    service.deleteTodo(id);
    model.clear();
    return "redirect:/list-todo";
}
}