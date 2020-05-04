package ru.itis.controllers;
/*
 * @author Rustem Khairutdinov
 * @group 11-602
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.recall.RecallCreationDto;
import ru.itis.dto.recall.RecallDto;
import ru.itis.models.Recall;
import ru.itis.services.RecallService;

import java.util.List;

@RestController
@RequestMapping("recalls")
public class RecallController {

    @Autowired
    private RecallService recallService;

    /*
     * Метод возвращает список отзывов
     */
    @GetMapping("/list")
    public List<RecallDto> getRecalls(){

        List<Recall> recalls = recallService.findAllCheckedRecalls();

        return RecallDto.from(recalls);
    }

    /*
     * Метод возвращает список отзывов с учетом {query} по имени компании
     */
    @GetMapping("/list/{query}")
    public List<RecallDto> getRecallsByQuery(@PathVariable("query") String query){
        return RecallDto.from(recallService.getRecallsByQuery(query));
    }

    /*
     * Метод возвращает отзыв по {recall_id}
     */
    @GetMapping("/recall/{recall_id}")
    public RecallDto getRecall(@PathVariable("recall_id") Long id){

        Recall recall = recallService.getRecallById(id);

        return RecallDto.from(recall);
    }


    /*
     * Метод создаёт запрос на создание отзыва
     */
    @PostMapping("/recall")
    public void postRecall(@RequestBody RecallCreationDto recall, Authentication authentication){
        recallService.save(recall, authentication);
    }
}
