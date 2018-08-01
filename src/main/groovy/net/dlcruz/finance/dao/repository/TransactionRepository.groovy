package net.dlcruz.finance.dao.repository

import net.dlcruz.finance.dao.domain.Account
import net.dlcruz.finance.dao.domain.Transaction
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByAccountOrderByDateDescIdDesc(Account account)

    Page<Transaction> findAllByAccountOrderByDateDescIdDesc(Account account, Pageable pageable)

    @Query('select min(t.date) from Transaction t where t.account = :account')
    Date getFirstTransactionDate(@Param('account') Account account)

    @Query('select max(t.date) from Allocation a join a.transaction t where t.account = :account')
    Date getLastTransactionDate(@Param('account') Account account)
}