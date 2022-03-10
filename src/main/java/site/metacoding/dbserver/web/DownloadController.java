package site.metacoding.dbserver.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.dbserver.domain.HospitalDto;
import site.metacoding.dbserver.domain.HospitalRepository;

@RequiredArgsConstructor
@Controller
public class DownloadController {
    private final HospitalRepository hospitalRepository;

    @GetMapping("/download")
    public String download(Model model) {

        RestTemplate rt = new RestTemplate();
        HospitalDto[] response = rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구",
                HospitalDto[].class);

        List<HospitalDto> hospitallist = Arrays.asList(response);

        hospitalRepository.saveAll(hospitallist);
        model.addAttribute("hospitals", hospitalRepository.findAll());

        return "list";
    }

    @GetMapping("/")
    public String list() {

        return "download";
    }

}
