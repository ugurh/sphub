package io.ugurh.sphub.account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author harun ugur
 * @project resttemplate-interceptor
 * @created 4.05.2023 - 19:51
 */

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Account>> findByEmail(@RequestParam String email) {
        List<Account> accounts = accountService.findByEmail(email);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Account>> findAll(@RequestParam Integer page, Integer size, String sortBy) {
        List<Account> accounts = accountService.findAllWithPagination(page, size, sortBy);
        return ResponseEntity.ok(accounts);
    }

    @PostMapping(value = "/add1", consumes = "application/json")
    public ResponseEntity<Boolean> add1(@RequestBody List<Account> accounts) {
        boolean result = accountService.addAccounts1(accounts);

        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        Account result = accountService.create(account);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        accountService.delete(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Integer id) {
        Account account = accountService.findAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
