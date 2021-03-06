package cl.proteinlab.rfid.controllers;

import com.impinj.octane.ImpinjReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import cl.proteinlab.rfid.service.ReaderService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Patricio A. Pérez Valverde
 * @since 23-03-17
 */
@RestController
@RequestMapping(path = "/write")
public class TagWriterController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping(method = GET, path = "/start")
    public Map<String, Object> startWritingTags() {
        Map<String, Object> response = new HashMap<String, Object>();

        ImpinjReader reader = readerService.startWriter();
        if (reader.isConnected()) {
            response.put("ok", true);
        } else {
            response.put("ok", false);
        }
        return response;
    }

    @RequestMapping(method = GET, path = "/stop")
    public Map<String, Object> stopWritingTags() {
        Map<String, Object> response = new HashMap<String, Object>();

        ImpinjReader reader = readerService.stopReader();
        if (!reader.isConnected()) {
            response.put("ok", true);
        } else {
            response.put("ok", false);
        }
        return response;
    }
}
