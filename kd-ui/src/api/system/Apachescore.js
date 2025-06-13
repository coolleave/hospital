import request from '@/utils/request'

// 查询生理评分列表
export function listApachescore(query) {
  return request({
    url: '/system/Apachescore/list',
    method: 'get',
    params: query
  })
}

// 查询生理评分详细
export function getApachescore(Id) {
  return request({
    url: '/system/Apachescore/' + Id,
    method: 'get'
  })
}

// 新增生理评分
export function addApachescore(data) {
  return request({
    url: '/system/Apachescore',
    method: 'post',
    data: data
  })
}

// 修改生理评分
export function updateApachescore(data) {
  return request({
    url: '/system/Apachescore',
    method: 'put',
    data: data
  })
}

// 删除生理评分
export function delApachescore(Id) {
  return request({
    url: '/system/Apachescore/' + Id,
    method: 'delete'
  })
}
