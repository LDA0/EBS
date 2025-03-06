package com.example.ebs.data.repositories

import com.example.ebs.data.repositories.remote.DataTest
import com.example.ebs.data.repositories.remote.DataTestRepository
import com.example.ebs.data.repositories.remote.EBSApiService

/**
 * Network Implementation of repository that retrieves amphibian data from underlying data source.
 */
class RemoteEBSRepository(
    private val ebsApiService: EBSApiService
) : DataTestRepository {
    /** Retrieves list of amphibians from underlying data source */
    override suspend fun getData(): List<DataTest> = ebsApiService.getData()
}

