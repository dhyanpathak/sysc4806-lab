package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class BuddyInfoController {

    private final BuddyInfoRepository repository;

    BuddyInfoController(BuddyInfoRepository repository) {
        this.repository = repository;
    }

    private final AtomicLong counter = new AtomicLong();

    // Go to create buddy form by GET -> /greeting

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("template", new BuddyInfo());
        return "greeting";
    }

    @PostMapping("/buddyinfo")
    public String createBuddy(@ModelAttribute BuddyInfo bud, Model model) {
        bud.setId(counter.incrementAndGet());
        repository.save(bud);
        model.addAttribute("buddy", bud);
        return "result";
    }

    @GetMapping("/buddyinfo/{id}")
    public String viewBuddy(@PathVariable Long id, Model model) throws Exception {
        BuddyInfo bud = repository.findById(id)
                .orElseThrow(() -> new Exception());
        model.addAttribute("buddy", bud);
        return "result";
    }
}