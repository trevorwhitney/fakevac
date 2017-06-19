package com.trevorwhitney.fakevac.nest

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class NestConfig(@Value("\${nest.rootUrl}") val rootUrl: String)

