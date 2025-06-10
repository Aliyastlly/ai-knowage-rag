package cn.ali.ai.rag.trigger.http;

import cn.ali.ai.rag.api.IAiService;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController()
@CrossOrigin("*")
@RequestMapping("/api/v1/ollama/")
public class OllamaController implements IAiService {
    @Resource
    private OllamaChatClient chatClient;
    @RequestMapping(value = "generate", method = RequestMethod.GET)
    /**
     * http://localhost:1579/api/v1/ollama/generate?model=deepseek-r1:1.5b&message=1+1
     */
    @Override
    public ChatResponse generate(@RequestParam String model, @RequestParam String message) {
        return chatClient.call(new Prompt(message, OllamaOptions.create().withModel(model)));
    }

    @RequestMapping(value = "generate_stream", method = RequestMethod.GET)
/**
 * http://localhost:1579/api/v1/ollama/generate_stream?model=deepseek-r1:1.5b&message=hi
 */
    @Override
    public Flux<ChatResponse> generateStream(@RequestParam String model, @RequestParam String message) {
        return chatClient.stream(new Prompt(message, OllamaOptions.create().withModel(model)));
    }
}
