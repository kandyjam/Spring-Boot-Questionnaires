package de.fuberlin.hcc.questionnaires;

import de.fuberlin.hcc.questionnaires.model.QuestionnaireWithAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideosController {


    private EditService editService;
    private SummaryService summaryService;
    private ViewService viewService;

    @Autowired
    public VideosController(EditService editService,
                            SummaryService summaryService,
                            ViewService viewService){
        this.editService = editService;
        this.summaryService = summaryService;
        this.viewService = viewService;

    }


    @RequestMapping("/view/contextKey?={contextKey}&questionnaireId={questionnaireId}&userId={userId}")
    public String showQuestionnaire(@PathVariable long contextKey,
                                    @PathVariable long questionnaireId,
                                    @PathVariable long userId,
                                    Model model){

        QuestionnaireWithAnswers questionnaireWithAnswers=
                viewService.getQuestionnaireWithAnswers(questionnaireId,contextKey,userId);
        model.addAttribute("questionnaireAndAnswers", questionnaireWithAnswers);
        return "questionnaireWithAnswers";
    }

}