package com.example.ebs.data.repositories

import com.example.ebs.data.repositories.local.Item
import com.example.ebs.data.repositories.local.ItemDao
import com.example.ebs.data.repositories.local.ItemsRepository
import kotlinx.coroutines.flow.Flow

class LocalItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)
}