package itiseveri.pcto.pcto.controller;

import itiseveri.pcto.pcto.model.User;
import itiseveri.pcto.pcto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ControllerPrincipale {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUser(ModelMap model){
        List<User> userList=userService.getAllUsers();
        model.addAttribute("listaUser", userList);
        return "lista";
    }


    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String addNewUser(ModelMap model){
        User user=new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        userService.createOrUpdateUser(user);
        return "redirect:/list";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/list";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

}
