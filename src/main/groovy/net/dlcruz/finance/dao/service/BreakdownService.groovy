package net.dlcruz.finance.dao.service

import net.dlcruz.finance.dao.domain.Account
import net.dlcruz.finance.dao.domain.Breakdown
import net.dlcruz.finance.dao.domain.Frequency

interface BreakdownService {

    List<Breakdown> getBreakdown(Frequency frequency, Account account)

    List<Breakdown> getBreakdown(Frequency frequency)
}