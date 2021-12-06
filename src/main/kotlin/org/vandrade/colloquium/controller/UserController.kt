package org.vandrade.colloquium.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 2:29 PM
 */

@RestController
@RequestMapping("/users")
class UserController {
    @GetMapping("/me")
    fun user(@AuthenticationPrincipal principal: OAuth2User): Map<String, Any?> =
        mapOf(Pair("username", principal.getAttribute("login")))
}