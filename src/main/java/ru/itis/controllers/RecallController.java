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

import java.util.List;

@RestController
@RequestMapping("recalls")
public class RecallController {

    /*
     * Метод возвращает список отзывов
     */
    @GetMapping("/list")
    public List<RecallDto> getRecalls(){
        //TODO
        return null;
    }

    /*
     * Метод возвращает список отзывов с учетом {query} по имени компании
     */
    @GetMapping("/list/{query}}")
    public List<RecallDto> getRecallsByQuery(@PathVariable("query") String query){
        //TODO
        return null;
    }

    /*
     * Метод возвращает отзыв по {recall_id}
     */
    @GetMapping("/recall/{recall_id}")
    public RecallDto getRecall(@PathVariable("recall_id") Long id){
        //TODO
        return null;
    }


    /*
     * Метод создаёт запрос на создание отзыва
     */
    @PostMapping("/recall")
    public void postRecall(@RequestBody RecallCreationDto recall, Authentication authentication){
        //TODO
    }
}
