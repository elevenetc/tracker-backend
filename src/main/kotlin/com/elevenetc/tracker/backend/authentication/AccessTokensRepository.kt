package com.elevenetc.tracker.backend.authentication

import org.springframework.data.repository.CrudRepository

interface AccessTokensRepository : CrudRepository<AccessToken, Long>