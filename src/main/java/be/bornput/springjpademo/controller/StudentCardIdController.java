package be.bornput.springjpademo.controller;

import be.bornput.springjpademo.model.StudentIdCard;
import be.bornput.springjpademo.service.StudentIdCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentCardIdController {

    private final StudentIdCardService StudentIdCardService;

    public StudentCardIdController(StudentIdCardService StudentIdCardService) {
        this.StudentIdCardService = StudentIdCardService;
    }

    @GetMapping("/StudentIdCards")
    public List<StudentIdCard> getAllStudentIdCards() {
        return StudentIdCardService.findAllStudentIdCards();
    }

    @GetMapping("/StudentIdCard/{id}")
    public StudentIdCard getStudentIdCardById(@PathVariable Long id) {

        StudentIdCard StudentIdCard = StudentIdCardService.getStudentIdCardById(id).get();
        if (StudentIdCardService.getStudentIdCardById(id).isPresent()) {
            return StudentIdCard;
        }
        else
        {
            Optional<StudentIdCard> optionalStudentIdCard = Optional.of(StudentIdCard);
            return optionalStudentIdCard.get();
        }
    }

    @GetMapping("/student/{id}/studentIdCard")
    public StudentIdCard getStudentIdCardByStudentId(@PathVariable Long id) {
        return StudentIdCardService.getStudentIdCardByStudentId(id);
    }

    @GetMapping("/cardNumber/{cardNumber}/studentIdCard")
    public StudentIdCard getStudentIdCardByStudentId(@PathVariable String cardNumber) {
        return StudentIdCardService.getStudentIdCardByCardNumber(cardNumber);
    }

}
