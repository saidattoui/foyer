package tn.esprit.foyer.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.services.IBlocService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    IBlocService blocService;

    // http://localhost:8089/foyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    @ResponseBody
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    // http://localhost:8089/foyer/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{blocId}")
    @ResponseBody
    public Bloc retrieveBloc(@PathVariable("blocId") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }

    // http://localhost:8089/foyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    @ResponseBody
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc= blocService.addBloc(b);
        return bloc;
    }

    // http://localhost:8089/foyer/bloc/update-bloc
    @PutMapping("/update-bloc")
    @ResponseBody
    public Bloc updateBloc(@RequestBody Bloc b) {
        Bloc bloc= blocService.updateBloc(b);
        return bloc;
    }
    // http://localhost:8089/foyer/bloc/removeBloc
    @DeleteMapping("/removeBloc/{idBloc}")
    @ResponseBody
    public void removeBloc(@PathVariable("idBloc") Long idBloc) {
        blocService.removeBloc(idBloc);
    }


    // http://localhost:8089/foyer/bloc/findByFoyerUniversiteIdUniversite/1
    @GetMapping("/findByFoyerUniversiteIdUniversite/{idUniversite}")
    @ResponseBody
    public List<Bloc> findByFoyerUniversiteIdUniversite(@PathVariable("idUniversite") Long idUniversite) {
        List<Bloc> listBlocsByFoyerUniversiteIdUniversite = blocService.findByFoyerUniversiteIdUniversite(idUniversite);
        return listBlocsByFoyerUniversiteIdUniversite;
    }


    // http://localhost:8089/foyer/bloc/affecterChambresABloc/C
    @PutMapping("/affecterChambresABloc/{nomBloc}")
    @ResponseBody
    public Bloc affecterChambresABloc (@RequestBody List<Long> numChambre, @PathVariable("nomBloc") String nomBloc)
    {
        Bloc bloc= blocService.affecterChambresABloc(numChambre,nomBloc);
        return bloc;
    }
}
